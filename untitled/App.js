/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {FlatList, StyleSheet, Text, View, SafeAreaView} from 'react-native';

let data = Array(1001);
for (var i = 0; i < data.length; i++) {
  let color =
    'rgb(' +
    Math.floor(Math.random() * 256) +
    ',' +
    Math.floor(Math.random() * 256) +
    ',' +
    Math.floor(Math.random() * 256) +
    ')';
  data[i] = {
    key: String(i),
    color: color,
  };
}

// eslint-disable-next-line no-undef
let FlatListBasics;
export default FlatListBasics = () => {
  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.container}>
        <FlatList
          accessibilityLabel={'long_list'}
          data={data}
          ItemSeparatorComponent={FlatListItemSeparator}
          renderItem={({item}) => {
            let label = item.key;
            return (
              <CustomRow index={item.key} color={item.color} label={label}>
                {' '}
              </CustomRow>
            );
          }}
        />
      </View>
    </SafeAreaView>
  );
};

const FlatListItemSeparator = () => {
  return <View style={{height: 16, width: '100%', backgroundColor: '#FFF'}} />;
};

const CustomRow = ({index, color, label}) => (
  <View style={[styles.item_container, {backgroundColor: color}]}>
    <Text accessibilityLabel={label} style={styles.item}>
      {index}
    </Text>
  </View>
);

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  item_container: {
    height: 100,
  },
  item: {
    textAlign: 'center',
    textAlignVertical: 'center',
    justifyContent: 'center',
    fontSize: 18,
    height: 100,
  },
});

//export default App;
