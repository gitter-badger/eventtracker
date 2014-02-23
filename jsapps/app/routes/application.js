export default Em.Route.extend({
  actions: {
   goBack: function(){
    window.history.back(); 
   }
  }
});