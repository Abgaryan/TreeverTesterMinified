// create timeline here for the better code visibility
var timeline = new TimelineMax();
var isPlaying = true;

var touch_screen_event = new CustomEvent('touch_screen_event');
var animation_start = new CustomEvent('animation_start');

function initListenners () {
     console.log("init listenners...");
     $(".hide_it").removeClass("hide_it");
     $("svg").attr("class", " ");
    $("#touch_screen").click(function() {
        if (timeline.progress() == 1) {
// uncomment this block for click to restart
            timeline.restart();

            isPlaying = true;
            var audio = document.getElementById('audio');
            audio.play(); //call this to play the song right away

            return;
        };

        if (isPlaying) {
            // pause playback
            console.log("pause");
            $("#play_button").css('visibility', 'visible');
            isPlaying = false;
            timeline.pause();
            extension_onPauseAnimation(timeline.time());
        } else {
            // resume playback
            console.log("resume");
            $("#play_button").css('visibility', 'hidden');
            isPlaying = true;
            timeline.resume();
            extension_onResumeAnimation();
        }

        // Trigger event for templates
        window.dispatchEvent(touch_screen_event);

    });
    
    timeline.eventCallback("onStart", extension_onStartAnimation);
    timeline.eventCallback("onComplete", extension_onEndAnimation); // check this one

    window.document.addEventListener("visibilitychange", function( e) {
        if(window.document.visibilityState == 'visible'){
         var audio = document.getElementById('audio');
         audio.play();
        console.log('VISIBILITY ', window.document.visibilityState);
        }else if (window.document.visibilityState == 'hidden' ){
          var audio = document.getElementById('audio');
          audio.pause();
        console.log('UN VISIBILITY ', window.document.visibilityState);
        }

        });
}

// extensions part to hook with the Native application
var ms_since_start = 0;

// returns the msElapsedSinceStart   for restarts
function extension_onStartAnimation () {
    // this is a hook request, so the webview can externally
    // catch the event of animation start
//    window.location.href = "localhost://start_hook";

    ms_since_start = 0;
    window.JSInterface.onStartAnimation(ms_since_start)
    window.dispatchEvent(animation_start);
    return ms_since_start;
}

// notify pause request
function extension_onPauseAnimation (msSinceStart) {
    // pause audio with JS
    window.JSInterface.onPauseAnimation(msSinceStart,0)
    var audio = document.getElementById('audio');
    audio.pause();
    
    // this is a hook request, so the webview can externally
    // catch the event of animation finish
//    window.location.href = "localhost://pause_hook";


    
    ms_since_start = msSinceStart;
}

//   resume has been requested
function extension_onResumeAnimation () {
    // resume audio with JS
     window.JSInterface.onResumeAnimation(ms_since_start);
    var audio = document.getElementById('audio');
    audio.play();

    // this is a hook request, so the webview can externally
    // catch the event of animation finish
//    window.location.href = "localhost://resume_hook";



    return ms_since_start;
}

//   animation will end
function extension_onEndAnimation () {
    // stop the music
     window.JSInterface.onEndAnimation(0)
    var audio = document.getElementById('audio');
    audio.pause();

    // this is a hook request, so the webview can externally
    // catch the event of animation finish
//     window.location.href = "localhost://finish_hook";

    console.log("end of animation");

    return;
}

//  return 1 if restart has been requested
function extension_onCheckRestart (anim_restart, ms_from_start) {
window.JSInterface.onCheckRestart(anim_restart, ms_from_start);
    return 0;
}
