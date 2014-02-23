export default Em.Route.extend({
  actions: {
   goToContacts: function(){
     this.transitionTo('contacts.list');
   }
  }
});