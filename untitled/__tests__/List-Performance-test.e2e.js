import wd from 'wd';
import config from '../e2e-config';

const port = 4723;
const driver = wd.promiseChainRemote('localhost', port);
jasmine.DEFAULT_TIMEOUT_INTERVAL = 60 * 60 * 1000; // одна  година

describe('UI Performance Example', () => {
  beforeAll(async () => {
    try {
      await driver.init(config);
    } catch (err) {
      console.log(err);
    }
  });
  afterAll(async () => await driver.quit());

  test('render home screen', async () => {
    //let list = await driver.elementByAccessibilityId('long_list');
    var isVisible = false;
    while (!isVisible) {
      await driver.execute('mobile: swipe', {direction: 'up'});
      //await driver.execute('mobile: scroll', {direction: 'down'});
    }
    // let item100 = await driver.elementByAccessibilityId('100');
    // expect(await item100.text()).toBe('100');
  });
});
