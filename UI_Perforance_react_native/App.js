/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {Component, createRef} from 'react';
import {
  FlatList,
  StyleSheet,
  Text,
  View,
  SafeAreaView,
  Image,
  Animated,
  Easing,
  Button,
} from 'react-native';

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
let flatList = createRef();


// eslint-disable-next-line no-undef
let FlatListBasics;
export default FlatListBasics = () => {
  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.container}>
        <FlatList
          scrollEnabled={true}
          flatListRef={React.createRef()}
          ref={flatList}
          testID={'long_list'}
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
        <View
          style={{
            left: 0,
            position: 'absolute',
            right: 0,
            top: 0,
          }}>
          <Button onPress={startScrool()} title="Start scrool" color="grey" />
        </View>
      </View>
    </SafeAreaView>
  );
};

function startScrool() {
  //flatList.scrollToOffset({offset: 130});
}

const FlatListItemSeparator = () => {
  return <View style={{height: 16, width: '100%', backgroundColor: '#FFF'}} />;
};

const IMAGES = {
  image0: require('./images/0.jpeg'),
  image1: require('./images/1.jpeg'),
  image2: require('./images/2.jpeg'),
  image3: require('./images/3.jpeg'),
  image4: require('./images/4.jpeg'),
  image5: require('./images/5.jpeg'),
  image6: require('./images/6.jpeg'),
  image7: require('./images/7.jpeg'),
  image8: require('./images/8.jpeg'),
  image9: require('./images/9.jpeg'),
  image10: require('./images/10.jpeg'),
  image11: require('./images/11.jpeg'),
  image12: require('./images/12.jpeg'),
  image13: require('./images/13.jpeg'),
  image14: require('./images/14.jpeg'),
  image15: require('./images/15.jpeg'),
  image16: require('./images/16.jpeg'),
  image17: require('./images/17.jpeg'),
  image18: require('./images/18.jpeg'),
  image19: require('./images/19.jpeg'),
};

function getImage(num) {
  return IMAGES['image' + (num % 20)];
}

const spinValue = new Animated.Value(0);

const spin = spinValue.interpolate({
  inputRange: [0, 1],
  outputRange: ['0deg', '360deg'],
});

Animated.loop(
  Animated.timing(spinValue, {
    toValue: 1,
    duration: 3000,
    easing: Easing.linear,
    useNativeDriver: true,
  }),
).start();

const CustomRow = ({index, color, label}) => {
  return (
    <View style={[styles.item_container, {backgroundColor: color}]}>
      <Image
        style={styles.image}
        source={getImage(index)}
        resizeMode={'stretch'}
      />
      <Animated.Image
        style={{transform: [{rotate: spin}], height: 100, width: 100}}
        source={getImage(index)}
        resizeMode={'stretch'}
      />
      <Text accessibilityLabel={label} style={styles.item}>
        {index}
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  item_container: {
    height: 100,
    flexDirection: 'row',
  },
  image: {
    height: 100,
    width: 100,
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
