export default Ember.Route.extend({
  model: function() {
    return [{event_id: 1, event_name: 'SkyFall',event_date:'2012-09-18',participants:['Akram','Hyder','Naveen','Sarath','Saravanan','Suresh']},
           {event_id: 2, event_name: 'EthirNeechal',event_date:'2013-06-24',participants:['Hyder','Naveen','Sarath','Saravanan','Sriram','Suresh']}];
  }
});