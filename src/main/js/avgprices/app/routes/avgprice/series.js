import Ember from 'ember';

export default Ember.Route.extend({
  queryParams: {
    area: {
      refreshModel: true
    },
    item: {
      refreshModel: true
    }
  },

  model: function(params) {
    if (params.area && params.item) {
      return this.store.find('series', 'APU' + params.area + params.item);
    }
  }
});