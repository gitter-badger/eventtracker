var attr = DS.attr;

var Contact = DS.Model.extend({
  contact_name: attr(),
  email: attr(),
  gravatar_email: attr()
});

Contact.reopenClass({
  FIXTURES: [
    {
      contact_name: 'selvagsz',
      email: 'selvagsz@gmail.com',
      id: 1
    },
    {
      contact_name: 'hyder',
      email: 'hyder@gmail.com',
      id: 2
    },
    {
      contact_name: 'suresh',
      email: 'suresh@gmail.com',
      id: 3
    },
    {
      contact_name: 'sarath',
      email: 'sarath@gmail.com',
      id: 4
    },
    {
      contact_name: 'Saravana',
      email: 'saravana@gmail.com',
      id: 5
    },
    {
      contact_name: 'Sri Ram',
      email: 'sriram@gmail.com',
      id: 6
    }
  ]
});

export default Contact;