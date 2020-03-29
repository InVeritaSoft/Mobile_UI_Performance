

// Imports the Flutter Driver API.
import 'package:flutter_driver/flutter_driver.dart';
import 'package:test/test.dart';

const pauseScroolDuration = Duration(seconds: 2);
const  scroolDuration =  Duration(milliseconds: 800);

void main() {


  group('UI Performance App', () {

    FlutterDriver driver;

    // Connect to the Flutter driver before running any tests.
    setUpAll(() async {
      driver = await FlutterDriver.connect();
    });

    // Close the connection to the driver after the tests have completed.
    tearDownAll(() async {
      if (driver != null) {
        driver.close();
      }
    });


    test('scrool test', () async {

      final listView = find.byValueKey('long_list');

      var bottom  = await driver.getBottomLeft(listView);
      var top  = await driver.getTopLeft(listView);
      var step = (bottom.dy - top.dy)*0.6;


      final item0Finder = find.byValueKey('item_0_text');
      expect(await driver.getText(item0Finder), '0');

      var scrollUntilVisible = (
          FlutterDriver driver,
          SerializableFinder scrollable,
          SerializableFinder item, {
            Duration scroolDuration = const  Duration(milliseconds: 100),
            Duration pauseDuration = const  Duration(milliseconds: 500),
            double alignment = 0.0,
            double dxScroll = 0.0,
            double dyScroll = 0.0,
          }) async {
        assert(scrollable != null);
        assert(item != null);
        assert(alignment != null);
        assert(dxScroll != null);
        assert(dyScroll != null);
        assert(dxScroll != 0.0 || dyScroll != 0.0);
        bool isVisible = false;
        await Future<void>.delayed(pauseDuration);
        driver.waitFor(item).then<void>((_) { isVisible = true; });
        while (!isVisible) {
          await driver.scroll(scrollable, dxScroll, dyScroll, scroolDuration);
          await Future<void>.delayed(pauseDuration);
        }
        return driver.scrollIntoView(item, alignment: alignment);
      };

      var forwart = (step) async {

        final listFinder = find.byValueKey('long_list');

        final item100Finder = find.byValueKey('item_100_text');

        await scrollUntilVisible(
          driver,
          listFinder,
          item100Finder,
          dyScroll: step,
          scroolDuration: scroolDuration,
          pauseDuration: pauseScroolDuration
        );
        expect(
          await driver.getText(item100Finder),
          '100',
        );
      };

      var revert = (step) async {
        final listFinder = find.byValueKey('long_list');
        final item0Finder = find.byValueKey('item_0_text');
        await scrollUntilVisible(
          driver,
          listFinder,
          item0Finder,
          dyScroll: step,
          scroolDuration: scroolDuration,
          pauseDuration: pauseScroolDuration
        );
        expect(
          await driver.getText(item0Finder),
          '0',
        );
      };

      for(int i=0;i<1;i++){
        await forwart(-step);
        await revert(step);
      }
    }, timeout: Timeout(Duration(minutes: 5)));

  });




}
