import Ember from 'ember';

export default Ember.Route.extend({

  /**
   * Model hook loads the available Areas and Items from our web service.
   * @return {[type]}
   */
  model: function() {
    return Ember.RSVP.hash({
      areas: this.store.find('area'),
      items: this.store.find('item')
    });
  }

});
