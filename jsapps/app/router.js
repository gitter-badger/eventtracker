var Router = Ember.Router.extend(); // ensure we don't share routes between all Router instances

Router.map(function() {
  this.route('component-test');
  this.route('helper-test');
   this.resource('events', function() {
     this.route('new');
     this.route('list');
     this.route('details',{path: '/:event_id'});
     this.route('edit',{path: '/:event_id/edit'});
   });
  
  this.resource('contacts', function(){
    this.route('list');
    this.route('new');
    this.route('details', {path: '/:contact_id'});
    this.route('edit', {path: '/:contact_id/edit'});
  });
});

export default Router;
