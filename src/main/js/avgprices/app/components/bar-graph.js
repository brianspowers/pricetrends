import Ember from 'ember';

/**
 * Bar Graph Component
 *
 * Uses the Flot library to render a vertical filled bar graph for a set of data.
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

    var flotSeries = seriesData.map(function(item, index) {
      return [index, item.value];
    });

    return [{
      color: 'rgb(137, 179, 98)',
      data: flotSeries
    }];
  }),

  /**
   * Explicit array of x-axis labels.
   */
  xAxisLabels: Ember.computed('seriesData', function() {
    var seriesData = this.get('seriesData');

    var axisLabels = seriesData.map(function(item) {
      return item.periodName.substring(0, 3) + ' ' + item.year;
    });

    return axisLabels;
  }),

  /**
   * Options object passed to Flot.
   */
  options: Ember.computed('xAxisLabels', function() {
    var xAxisLabels = this.get('xAxisLabels');
    return {
      series: {
        bars: {
          show: true,
          barWidth: 0.7,
          align: 'center'
        }
      },
      xaxis: {
        // Make sure we don't try to render labels for values we don't actually have.
        tickDecimals: 0,
        tickFormatter: function(val) {
          return xAxisLabels[val] || "";
        }
      },
      yaxis: {
        tickFormatter: function(val) {
          return '$' + val.toFixed(2);
        }
      }
    };
  })
});