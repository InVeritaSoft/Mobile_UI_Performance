import 'dart:math';
import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

Random rand = Random();

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


class TestPage extends StatelessWidget{

  TestPage({Key key, this.title}) : super(key: key);



  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.separated(
        key: ValueKey('long_list'),
        separatorBuilder: (context,int){
          return Divider();
        },
        itemCount: 1001,
        itemBuilder: (context,index){

          return  Cell(index:index);
        },
      ),
    );
  }



}

class Cell extends StatefulWidget {

  final int index;


  Cell({Key key, this.index}) : super(key: key);

  @override
  _CellState createState() => _CellState();
}

class _CellState extends State<Cell> with TickerProviderStateMixin {

  AnimationController rotationController;

  @override
  void initState() {
    super.initState();
    rotationController = AnimationController(duration: const Duration(milliseconds: 3000), vsync: this);
    rotationController.addStatusListener((status) {
      if(status == AnimationStatus.completed){
        rotationController.forward(from:0.0);
      }
    });
    rotationController.forward();

  }

  @override
  void dispose() {
    rotationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 100,color: randomColor(),
      child: Row(
        children: <Widget>[
          Image.asset(
            getImage(widget.index),
            height: 100.0,
            width: 100.0,
            fit: BoxFit.fill,
          ),
          RotationTransition(
            turns:Tween(begin: 0.0, end: 1.0).animate(rotationController),
            child: Image.asset(
              getImage(widget.index),
              height: 100.0,
              width: 100.0,
              fit: BoxFit.fill,
            ),
          ),

          Center(
            child: Text(
              widget.index.toString(),
              key: ValueKey('item_${widget.index}_text'),
            ),
          ),
        ],
      ),
    );
  }

  static randomColor(){
    return Color((rand.nextDouble() * 0xFFFFFF).toInt() << 0).withOpacity(1.0);
  }


  static getImage(index){
    var  url  = 'assets/images/${index % 20}.jpeg';
    return url;
  }
}

