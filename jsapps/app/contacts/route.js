export default Em.Route.extend({
  actions: {
    goToContacts: function () {
      this.transitionTo('contacts.list');
    },
    
    goToContactDetails: function(model){
      this.transitionTo('contacts.details', model);
    }

  }
});