//
//  ContentView.swift
//  UI_Perfomrance_SwiftUI
//
//  Created by NazarKo on 3/27/20.
//  Copyright © 2020 NazarKo. All rights reserved.
//

import SwiftUI

extension CGFloat {
    static func random() -> CGFloat {
        return CGFloat(arc4random()) / CGFloat(UInt32.max)
    }
}

extension UIColor {
    static func random() -> UIColor {
        return UIColor(red:   .random(),
                       green: .random(),
                       blue:  .random(),
                       alpha: 1.0)
    }
}


struct ContentView: View {
   let numbers = Array(0...1001);
   //let list =  numbers.map{str in Container(index: str) }
   var body: some View {
    List(numbers,id: \.self) { index in
        HStack {
            Text("\(index)").frame(
                maxWidth: .infinity,
                alignment: .center
                ).padding(0.0).accessibility(identifier: "item_\(index)")
        }.frame(height: 100).background(Color(UIColor.random())).padding(0.0)
    }.accessibility(identifier: "long_list").padding(0.0)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().padding(0.0)
    }
}
