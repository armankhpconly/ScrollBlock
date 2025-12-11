package com.example.scrollblock

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.os.SystemClock


class ScrollBlockAccesibilityservice : AccessibilityService() {

    private var startingTime :Long = 0
    private var totalTime :Long = 0


    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d("ScrollBlock", "Accessibility Service connected.")
    }

    override fun onInterrupt() {
        Log.d("ScrollBlock", "Accessibility Service interrupted.")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (event.packageName == "com.google.android.youtube" && event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            val rootNode = rootInActiveWindow
            if (rootNode != null) {
                checkForShorts(rootNode)
            }
        }
        if (event.packageName == "com.instagram.android" && event.eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            val rootNode = rootInActiveWindow
            if (rootNode != null) {
                checkForReels(rootNode)
            }
        }
        if(event.packageName=="com.snapchat.android" && event.eventType==AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED){
            val rootNode = rootInActiveWindow
            checkForSpotlight(rootNode)
        }

        }

    private fun checkForShorts(nodeInfo: AccessibilityNodeInfo?) {
        if (nodeInfo == null) return
        val contentDescription = nodeInfo.contentDescription?.toString()
        if (contentDescription != null) {
            if (contentDescription.contains("See more videos using this sound", ignoreCase = false)) {
                Log.d("ScrollBlock", "Short videos found")
                    shortDetected()

            }
        }
        // Recursively traverse child nodes to continue checking bottom bar items
        for (i in 0 until nodeInfo.childCount) {
            checkForShorts(nodeInfo.getChild(i))
        }
    }
    private fun shortDetected() {
        Log.d("ScrollBlock", "Youtube shorts is active; navigating back.")
                performGlobalAction(GLOBAL_ACTION_BACK)

}
    private fun checkForReels(nodeInfo: AccessibilityNodeInfo?) : Boolean {
        if (nodeInfo == null) return false
        if (nodeInfo.className?.toString() == "androidx.viewpager.widget.ViewPager" && nodeInfo.contentDescription.isNullOrEmpty()) {
            //here we will check if this has seekbar , because the reel have viewpager and seekbar combination
            if (hasSeekBar(nodeInfo)) {
                startTimer()
                shortDetected()
            }
            else{
                stopTimer()
            }
        }
        for (i in 0 until nodeInfo.childCount) {
            checkForReels(nodeInfo.getChild(i))
        }
        return false
    }

    private fun checkForSpotlight(nodeInfo: AccessibilityNodeInfo?) {
        if (nodeInfo == null) return
        // Check for unique Spotlight identifier
        if (nodeInfo.className == "android.widget.TextView" &&
            nodeInfo.text == "Spotlight" &&
            nodeInfo.contentDescription == null &&
            !nodeInfo.isSelected
        ) {
            Log.d("ScrollBlock", "Spotlight detected; navigating back.")
            shortDetected()
            return
        }
        // Traverse child nodes
        for (i in 0 until nodeInfo.childCount) {
            checkForSpotlight(nodeInfo.getChild(i))
        }
    }

    private fun hasSeekBar(nodeInfo: AccessibilityNodeInfo?): Boolean {
        if (nodeInfo == null) return false
        if (nodeInfo.className?.toString()?.contains("SeekBar", ignoreCase = true) == true) {
            return true
        }
        for (i in 0 until nodeInfo.childCount) {
            if (hasSeekBar(nodeInfo.getChild(i))) {
                return true
            }
        }
        return false
    }
    //this is where we will start our timerr
    private fun startTimer() {
        if (startingTime == 0L) {
            startingTime = SystemClock.elapsedRealtime()
        }
    }
    //this will stop the countdown and add it to total time
    private fun stopTimer(){
        val elapsedTime = SystemClock.elapsedRealtime() - startingTime
        totalTime += elapsedTime
    }
}