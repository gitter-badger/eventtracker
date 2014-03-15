var attr = DS.attr;
export default DS.Model.extend({
  event_name: attr('string'),
  event_date: attr('string'),
  participants: DS.hasMany('contact')
});