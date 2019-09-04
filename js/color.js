
$("button").click(function(){
    $.ajax({
      type: 'GET',
    url: "/mastermind/startgame",
    success: function(colors, data, xhr){
      console.log("this almost works")
    },

    error: function(){
      console.log("something went wrong");
    }
});;
});

function colors(number){

  var colorArray = [];
  number = number.toString()
    for (var i = 0; i < number.length; i++) {
          var array = ["indianred", "black", "blue", "green", "greenyellow", "orange","steelblue","magenta","aquamarine","plum"];
          colorArray.push(array[number.charAt(i)]);
}
    return colorArray;
}
