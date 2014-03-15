export default Ember.Route.extend({
  model: function(params) {
    return this.store.find('event',params.id);
  },
  serialize: function(model){
    return {id: model.id};
  },
  actions: {
    edit: function() {
      this.transitionTo('events.edit', this.get('controller.id'));
    }
  }
});