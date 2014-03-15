export default Ember.ObjectController.extend({
  isNew: Ember.computed.empty('event_id'),
  actions: {
    addparticipant: function() {
      this.get('moreParticipants').pushObject(this.store.createRecord('contact'));
    },
    save: function(){
      var model = this.get('content'),
          participants = [],
          self = this;
      participants.push(this.get('firstparticipant'));
      participants.concat(this.get('moreParticipants'));
      model.set('participants',participants);
      model.save().then(function(){
        self.transitionToRoute('events.details',model.get('id'));
      });
    }
  }
});