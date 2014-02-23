export default Ember.Component.extend({
  gravatarUrl: function(){
    var email = this.get('email');
    return !Em.isEmpty(email)? "http://www.gravatar.com/avatar/"+MD5(email)+"&s=200" : '';
  }.property('email')
});
