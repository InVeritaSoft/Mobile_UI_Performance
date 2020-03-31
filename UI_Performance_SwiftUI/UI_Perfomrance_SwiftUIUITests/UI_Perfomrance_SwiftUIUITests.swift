//
//  UI_Perfomrance_SwiftUIUITests.swift
//  UI_Perfomrance_SwiftUIUITests
//
//  Created by NazarKo on 3/27/20.
//  Copyright © 2020 NazarKo. All rights reserved.
//

import XCTest
import SwiftUI

class UI_Perfomrance_SwiftUIUITests: XCTestCase {

    override func setUp() {
        continueAfterFailure = false
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testScrool() {
        let app = XCUIApplication()
        app.launch()
        for _ in 0...1 {
            forward(app: app)
            revert(app: app)
        }
    }
    
    func revert(app: XCUIApplication){
        let table = app.tables.element(boundBy: 0)
        let firstCell = table.cells.element(boundBy: 0)
        table.scrollToElement(element: firstCell,direction: XCUIElement.Direction.Down)
    }
    
    func forward(app: XCUIApplication){
        let table = app.tables.element(boundBy: 0)
        let lastCell = table.cells.element(boundBy:table.cells.count-1)
        table.scrollToElement(element: lastCell,direction: XCUIElement.Direction.Up)
    }
    


    func testLaunchPerformance() {
        if #available(macOS 10.15, iOS 13.0, tvOS 13.0, *) {
            measure(metrics: [XCTOSSignpostMetric.applicationLaunch]) {
                XCUIApplication().launch()
            }
        }
    }
}

extension XCUIElement
{
    
    func scrollToElement(element: XCUIElement,direction: Direction) {
        if (direction == .Up){
            while !element.visible() {
                swipeUp()
            }
        }else{
            while !element.visible() {
               swipeDown()
            }
        }
        
    }

    func visible() -> Bool {
        guard self.exists && !self.frame.isEmpty else { return false }
        return XCUIApplication().windows.element(boundBy: 0).frame.contains(self.frame)
    }
    
    
    enum Direction : Int {
        case Up, Down, Left, Right
    }
}


