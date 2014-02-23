export default Em.ObjectController.extend({
  title: function () {
    return Em.isEmpty(this.get('id')) ? 'New Contact' : 'Edit Contact';
  }.property('contact_id'),

  actions: {
    saveRecord: function(){
      var self = this,
          contactRecord = this.get('model');
  
      if(Em.isEmpty(this.get('id'))) {
        contactRecord = this.store.createRecord('contact', contactRecord);
      }
  
      contactRecord.save().then(function() {
        self.send('goToContactsDetails', contactRecord.get('id'));      
      }, Em.K);
    }
  }
});