export default Ember.Route.extend({
  controllerName: 'events.new',
  model: function(params) {
    return this.store.find('event',params.id);
  },
  setupController: function(controller,model){
    model.set('firstparticipant',model.get('participants.0'));
    model.set('moreParticipants',model.get('participants').slice(1));
    controller.set('content',model);
  },
  serialize: function(model){
    return {id: model.id};
  },
  renderTemplate: function() {
      this.render('events.new');
  }
});