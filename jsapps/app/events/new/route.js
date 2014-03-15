export default Ember.Route.extend({
  model: function(){
    var event  = this.store.createRecord('event');
    return event;
  },
  setupController: function(controller,model) {
    var contact = this.store.createRecord('contact',{name: 'Hyder'});
    controller.set('model',model);
    controller.set('firstparticipant',contact);
    controller.set('moreParticipants',[]);
  }
});