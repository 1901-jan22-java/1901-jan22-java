function display_time(){
    var refresh=1000; // Refresh rate in milli seconds
    mytime=setTimeout('display()',refresh)
    }
    
function display() {
    var time = new Date()
    time = time.getHours( )+ ":" +  time.getMinutes() + ":" +  time.getSeconds()
    $('#time').text(time);
    display_time();
}