import Ember from 'ember';

export default Ember.Controller.extend({

  selectedArea: null,

  selectedItem: null,

  goButtonDisabled: Ember.computed('selectedArea', 'selectedItem', function() {
    var selectedArea = this.get('selectedArea');
    var selectedItem = this.get('selectedItem');

    return !(selectedArea && selectedItem);
  }),

  actions: {
    /**
     * Action to take the selected Area and Item from the dropdowns and
     * issue a new request for data with Area & Item as query parameters.
     * @return {[type]}
     */
    showSeries: function() {
      var area = this.get('selectedArea');
      var item = this.get('selectedItem');
      this.transitionToRoute('avgprice.series', {
        queryParams: {
          area: area,
          item: item
        }
      });
    }
  }
});