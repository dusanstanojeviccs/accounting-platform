import { moduleForComponent, test } from 'ember-qunit';
import hbs from 'htmlbars-inline-precompile';

moduleForComponent('invoice-line-modal', 'Integration | Component | invoice line modal', {
  integration: true
});

test('it renders', function(assert) {
  // Set any properties with this.set('myProperty', 'value');
  // Handle any actions with this.on('myAction', function(val) { ... });

  this.render(hbs`{{invoice-line-modal}}`);

  assert.equal(this.$().text().trim(), '');

  // Template block usage:
  this.render(hbs`
    {{#invoice-line-modal}}
      template block text
    {{/invoice-line-modal}}
  `);

  assert.equal(this.$().text().trim(), 'template block text');
});
