/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Gimhani Uthpala
 */
public class GarmentController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
}
