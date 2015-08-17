package com.softwaremill.react.kafka.commit

import org.apache.curator.framework.CuratorFramework
import org.apache.curator.framework.recipes.locks.InterProcessMutex

/**
 * Based on from https://github.com/cjdev/kafka-rx
 */
class ZookeeperLock(zk: CuratorFramework, path: String) extends PartitionLock {
  val lock = new InterProcessMutex(zk, path)
  def acquire(): Unit = lock.acquire()
  def release(): Unit = lock.release()
}
