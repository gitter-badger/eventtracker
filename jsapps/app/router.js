var Router = Ember.Router.extend(); // ensure we don't share routes between all Router instances

Router.map(function() {
   this.resource('events', function() {
     this.route('new');
     this.route('list');
     this.route('details',{path: '/:event_id'});
     this.route('edit',{path: '/:event_id/edit'});
   });
  
  this.resource('contacts', function(){
    this.route('list');
    this.route('new');
    this.route('details', {path: '/:id'});
    this.route('edit', {path: '/:id/edit'});
  });
});

export default Router;
