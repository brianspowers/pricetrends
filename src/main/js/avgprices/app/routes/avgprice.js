import Ember from 'ember';

export default Ember.Route.extend({

  model: function() {
    return Ember.RSVP.hash({
      areas: this.store.find('area'),
      items: this.store.find('item')
    });
  }

});
