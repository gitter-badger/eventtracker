var get = Em.get;

export default Em.Route.extend({
  model: function(params) {    
    return this.store.find('contact', get(params, 'id'));;
  },
  
  serialize: function(model){
    return {id: get(model, 'id')};
  },
  
  actions: {
   edit: function(contact){
    this.transitonTo('contacts.edit', get(contact, 'id')); 
   }
  }
});