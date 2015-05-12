import ApplicationAdapter from './application';

export default ApplicationAdapter.extend({
  namespace: 'api/blsdata',

  pathForType: function() {
    return 'average_price';
  }

});
