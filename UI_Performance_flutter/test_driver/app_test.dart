
@Timeout(const Duration(seconds: 45))
// Imports the Flutter Driver API.
import 'package:flutter_driver/flutter_driver.dart';
import 'package:test/test.dart';

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

      final item0Finder = find.byValueKey('item_0_text');
      expect(await driver.getText(item0Finder), '0');

      var forwart = () async {
        final listFinder = find.byValueKey('long_list');
        final item10Finder = find.byValueKey('item_10_text');
        final item20Finder = find.byValueKey('item_20_text');
        final item30Finder = find.byValueKey('item_30_text');
        final item40Finder = find.byValueKey('item_40_text');
        final item50Finder = find.byValueKey('item_50_text');
        final item60Finder = find.byValueKey('item_60_text');
        final item70Finder = find.byValueKey('item_70_text');
        final item80Finder = find.byValueKey('item_80_text');
        final item90Finder = find.byValueKey('item_90_text');
        final item100Finder = find.byValueKey('item_100_text');
        final step = -(100.0 * 10);
        await driver.scrollUntilVisible(
          listFinder,
          item10Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item10Finder),
          '10',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item20Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item20Finder),
          '20',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item30Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item30Finder),
          '30',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item40Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item40Finder),
          '40',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item50Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item50Finder),
          '50',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item60Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item60Finder),
          '60',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item70Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item70Finder),
          '70',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item80Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item80Finder),
          '80',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item80Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item80Finder),
          '80',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item90Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item90Finder),
          '90',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item100Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item100Finder),
          '100',
        );
      };

      var revert = () async {
        final listFinder = find.byValueKey('long_list');
        final item0Finder = find.byValueKey('item_0_text');
        final item10Finder = find.byValueKey('item_10_text');
        final item20Finder = find.byValueKey('item_20_text');
        final item30Finder = find.byValueKey('item_30_text');
        final item40Finder = find.byValueKey('item_40_text');
        final item50Finder = find.byValueKey('item_50_text');
        final item60Finder = find.byValueKey('item_60_text');
        final item70Finder = find.byValueKey('item_70_text');
        final item80Finder = find.byValueKey('item_80_text');
        final item90Finder = find.byValueKey('item_90_text');
        final step = (100.0 * 10);

        await driver.scrollUntilVisible(
          listFinder,
          item90Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item90Finder),
          '90',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item80Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item80Finder),
          '80',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item70Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item70Finder),
          '70',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item60Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item60Finder),
          '60',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item50Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item50Finder),
          '50',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item40Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item40Finder),
          '40',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item30Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item30Finder),
          '30',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item20Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item20Finder),
          '20',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item10Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item10Finder),
          '10',
        );
        await driver.scrollUntilVisible(
          listFinder,
          item0Finder,
          dyScroll: step,
        );
        expect(
          await driver.getText(item0Finder),
          '0',
        );
      };

      for(int i=0;i<1;i++){
        await forwart();
        await revert();
      }
    }, timeout: Timeout(Duration(minutes: 5)));

  });
}
