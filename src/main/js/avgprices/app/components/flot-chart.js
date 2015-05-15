import Ember from 'ember';

/**
 * Component for rendering a Flot chart into an Ember application.
 */
export default Ember.Component.extend({
  data: [],
  options: {},
  plot: null,

  /**
   * Function that fires when the component is inserted into the DOM.  Sets up the initial chart plot.
   */
  setupFlotChart: Ember.on('didInsertElement', function() {
    var $this = this.$();

    var plot = $this.plot(this.get('data'), this.get('options')).data('plot');
    this.set('plot', plot);
  }),

  /**
   * Ember observer watching the graph data for changes and redrawing when appropriate.
   */
  redrawFlotChart: Ember.observer('data', function() {
    var plot = this.get('plot');
    plot.setData(this.get('data'));
    plot.setupGrid();
    plot.draw();
  })
});