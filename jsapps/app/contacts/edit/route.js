var get = Em.get;

export default Em.Route.extend({
  controllerName: 'contacts.new',
  model: function(params) {
   return this.store.find('contact', get(params, 'id'));
  },
  
  serialize: function(model) {
    return {id: get(model, 'id')};
  },
  
  renderTemplate: function(){
   this.render('contacts.new'); 
  }
});