// new Vue({
//   data: {
//     message: ''
//   },
//   methods: {
//     refreshMessage(resource) {
//       this.$http.get('/message').then((response) {
//         this.message = response.data.message;
//       });
//     }
//   }
// })

// Vue.component('sub-component', {
//   template: '<div>{{ message }}</div>',
//   props: [ 'message' ]
//   methods: {
//     refreshMessage() {
//       this.$emit('refreshMessage');
//     }
//   }
// });
var startButton = document.getElementById('startGame');
startButton.click(function(){
  $.get({
    url: "/mastermind/startgame",
    success: function(colors, data, xhr){
      console.log(colors);
      console.log(data);
      console.log(xhr);
    },

    error: function(){
      console.log("something went wrong");
    }
})
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
