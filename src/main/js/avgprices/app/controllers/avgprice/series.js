import Ember from 'ember';

export default Ember.Controller.extend({
  /**
   * Inject the parent controller
   */
  needs: ['avgprice'],
  
  queryParams: ['area', 'item'],

  area: null,

  item: null,

  showTrendTable: true,

  showLineGraph: false,

  showBarGraph: false,

  seriesHasData: Ember.computed('model.seriesData', function() {
    var seriesData = this.get('model.seriesData');
    return seriesData.length > 0;
  }),

  /**
   * Series data sorted in ascending order, used for Line and Bar Graph displays.
   */
  ascendingSeriesData: Ember.computed('model.seriesData', function() {
    var seriesData = this.get('model.seriesData');
    seriesData.sort(function(a, b) {
      var aDate = ''.concat(a.year, a.period);
      var bDate = ''.concat(b.year, b.period);
      if (aDate < bDate) {
        return -1;
      } else if (bDate < aDate) {
        return 1;
      } else {
        return 0;
      }
    });

    return seriesData;
  }),

  /**
   * Descending view of the series data, used for the Data Table display.
   */
  descendingSeriesData: Ember.computed('ascendingSeriesData', function() {
    return this.get('ascendingSeriesData').slice().reverse();
  }),

  /**
   * Helper method to set the Area and Item select boxes to the appropriate values 
   * if a user enters this route directly
   */
  _populateSelectors: Ember.observer('area', 'item', function() {
    var area = this.get('area');
    var item = this.get('item');
    if (area) {
      this.set('controllers.avgprice.selectedArea', area);
    }
    if (item) {
      this.set('controllers.avgprice.selectedItem', item);
    }
  }),

  actions: {
    /**
     * Action to switch the active visualization.
     */
    enableVis: function(visualization) {
      this.setProperties({
        showTrendTable: false,
        showLineGraph: false,
        showBarGraph: false
      });
      this.set(visualization, true);
    }
  }


});