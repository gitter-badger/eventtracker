export default Ember.ObjectController.extend({
  isNew: Ember.computed.empty('event_id'),
  actions: {
    addparticipant: function() {
      this.get('moreParticipants').pushObject();
    }
  }
});