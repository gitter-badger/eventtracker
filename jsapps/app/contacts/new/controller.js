export default Em.ObjectController.extend({
  title: function () {
    return Em.isEmpty(this.get('contact_id')) ? 'New Contact' : 'Edit Contact';
  }.property('contact_id'),

  actions: {
    saveRecord: function(){
      var self = this,
          contact = this.store.createRecord('contact', this.get('model'));
  
      contact.save().then(function() {
        self.send('goToContacts');      
      }, Em.K);
    }
  }
});