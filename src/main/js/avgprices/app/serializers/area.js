import DS from 'ember-data';

var lastId = 1;
export default DS.RESTSerializer.extend({

  // Cleaning up the payload as our back-end doesn't wrap the response in this key.
  normalizePayload: function(payload) {
    return {
      "areas": payload
    };
  },

  // For simplicity, we're not assigning real ids to these codes on our back-end so we're faking it here.
  normalizeHash: {
    areas: function(hash) {
      if (!hash.id) {
        hash.id = lastId++;
      }
      return hash;
    }
  }
});
