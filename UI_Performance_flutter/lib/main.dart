import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: TestPage(title: 'Flutter Demo Home Page'),
    );
  }

}


class TestPage extends StatelessWidget {

  TestPage({Key key, this.title}) : super(key: key);

  Random rand = Random();

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.separated(
        key: ValueKey('long_list'),
        separatorBuilder: (context,int){
          return Divider();
        },
        itemCount: 101,
        itemBuilder: (context,index){
          return  Container(
            height: 100,color: randomColor(),
            child: Center(
              child: Text(
                index.toString(),
                key: ValueKey('item_${index}_text'),
              ),
            ),
          );
        },
      ),
    );
  }

  randomColor(){
    return Color((rand.nextDouble() * 0xFFFFFF).toInt() << 0).withOpacity(1.0);
  }


}
