import DS from 'ember-data';

export default DS.RESTSerializer.extend({

  // Cleaning up the payload as our back-end doesn't wrap the response in this key.
  normalizePayload: function(payload) {
    return {
      "series": payload
    };
  },

  // For simplicity, we're not assigning real ids to these codes on our back-end so we're faking it here.
  normalizeHash: {
    series: function(hash) {
      hash.id = hash.seriesID;
      delete hash.seriesID;
      return hash;
    }
  }
});