export default Ember.Route.extend({
  controllerName: 'events.new',
  model: function(params) {
    return params;
  },
  setupController: function(controller,model){
    model = Ember.Object.create(model);
    model.set('firstparticipant',model.get('participants.0'));
    model.set('moreParticipants',model.get('participants').slice(1));
    controller.set('content',model);
  },
  serialize: function(model){
    return {event_id: model.event_id};
  },
  renderTemplate: function() {
      this.render('events.new');
  }
});