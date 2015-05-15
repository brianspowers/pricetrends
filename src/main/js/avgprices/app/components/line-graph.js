import Ember from 'ember';

/**
 * Line graph component.  
 *
 * Uses the Flot library.
 */
export default Ember.Component.extend({

  seriesData: [],
  
  /**
   * Bootstrap classes to maintain 16x9 aspect ratio as viewport is resized.
   * @type {Array}
   */
  classNames: ['embed-responsive', 'embed-responsive-16by9'],

  /**
   * Data object that will be passed to Flot to render the bar graph.
   */
  graphData: Ember.computed('seriesData', function() {
    var seriesData = this.get('seriesData');

    var flotSeries = seriesData.map(function(item) {
      var dateTime = convertToTime(item.period, item.year);
      return [dateTime, item.value];
    });

    return [{
      color: 'rgb(137, 179, 98)',
      data: flotSeries
    }];
  }),

  /**
   * Options object passed to Flot.
   */
  options: {
    xaxis: {
      mode: "time",
      timeformat: "%b %Y"
    },
    yaxis: {
      tickFormatter: function(val) {
        return '$' + val.toFixed(2);
      }
    }
  },
});

/**
 * Helper function to create a timestamp from the provided month and year.
 */
function convertToTime(period, year) {
  var month = period.slice(1);
  return Date.parse(year + '-' + month + '-01');
}