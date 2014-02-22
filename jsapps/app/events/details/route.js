export default Ember.Route.extend({
  model: function(params) {
    return params;
  },
  serialize: function(model){
    return {event_id: model.event_id};
  },
  actions: {
    edit: function() {
      this.transitionTo('events.edit', this.get('controller.content'));
    }
  }
});