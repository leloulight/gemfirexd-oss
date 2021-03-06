/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/cxxfunctional.h>

#include "gfxd_struct_StatementAttrs.h"

#include <algorithm>

namespace com { namespace pivotal { namespace gemfirexd { namespace thrift {

const char* StatementAttrs::ascii_fingerprint = "175D389614293BA940AE9B14466CCFB5";
const uint8_t StatementAttrs::binary_fingerprint[16] = {0x17,0x5D,0x38,0x96,0x14,0x29,0x3B,0xA9,0x40,0xAE,0x9B,0x14,0x46,0x6C,0xCF,0xB5};

uint32_t StatementAttrs::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_BYTE) {
          xfer += iprot->readByte(this->resultSetType);
          this->__isset.resultSetType = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->updatable);
          this->__isset.updatable = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->holdCursorsOverCommit);
          this->__isset.holdCursorsOverCommit = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->requireAutoIncCols);
          this->__isset.requireAutoIncCols = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->autoIncColumns.clear();
            uint32_t _size208;
            ::apache::thrift::protocol::TType _etype211;
            xfer += iprot->readListBegin(_etype211, _size208);
            this->autoIncColumns.resize(_size208);
            uint32_t _i212;
            for (_i212 = 0; _i212 < _size208; ++_i212)
            {
              xfer += iprot->readI32(this->autoIncColumns[_i212]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.autoIncColumns = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->autoIncColumnNames.clear();
            uint32_t _size213;
            ::apache::thrift::protocol::TType _etype216;
            xfer += iprot->readListBegin(_etype216, _size213);
            this->autoIncColumnNames.resize(_size213);
            uint32_t _i217;
            for (_i217 = 0; _i217 < _size213; ++_i217)
            {
              xfer += iprot->readString(this->autoIncColumnNames[_i217]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.autoIncColumnNames = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->batchSize);
          this->__isset.batchSize = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 8:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->fetchReverse);
          this->__isset.fetchReverse = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 9:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->lobChunkSize);
          this->__isset.lobChunkSize = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 10:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->maxRows);
          this->__isset.maxRows = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 11:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->maxFieldSize);
          this->__isset.maxFieldSize = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 12:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->timeout);
          this->__isset.timeout = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 13:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->cursorName);
          this->__isset.cursorName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 14:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->possibleDuplicate);
          this->__isset.possibleDuplicate = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 15:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->poolable);
          this->__isset.poolable = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 16:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->doEscapeProcessing);
          this->__isset.doEscapeProcessing = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 17:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->pendingTransactionAttrs.clear();
            uint32_t _size218;
            ::apache::thrift::protocol::TType _ktype219;
            ::apache::thrift::protocol::TType _vtype220;
            xfer += iprot->readMapBegin(_ktype219, _vtype220, _size218);
            uint32_t _i222;
            for (_i222 = 0; _i222 < _size218; ++_i222)
            {
              TransactionAttribute::type _key223;
              int32_t ecast225;
              xfer += iprot->readI32(ecast225);
              _key223 = (TransactionAttribute::type)ecast225;
              bool& _val224 = this->pendingTransactionAttrs[_key223];
              xfer += iprot->readBool(_val224);
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.pendingTransactionAttrs = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t StatementAttrs::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("StatementAttrs");

  if (this->__isset.resultSetType) {
    xfer += oprot->writeFieldBegin("resultSetType", ::apache::thrift::protocol::T_BYTE, 1);
    xfer += oprot->writeByte(this->resultSetType);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.updatable) {
    xfer += oprot->writeFieldBegin("updatable", ::apache::thrift::protocol::T_BOOL, 2);
    xfer += oprot->writeBool(this->updatable);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.holdCursorsOverCommit) {
    xfer += oprot->writeFieldBegin("holdCursorsOverCommit", ::apache::thrift::protocol::T_BOOL, 3);
    xfer += oprot->writeBool(this->holdCursorsOverCommit);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.requireAutoIncCols) {
    xfer += oprot->writeFieldBegin("requireAutoIncCols", ::apache::thrift::protocol::T_BOOL, 4);
    xfer += oprot->writeBool(this->requireAutoIncCols);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.autoIncColumns) {
    xfer += oprot->writeFieldBegin("autoIncColumns", ::apache::thrift::protocol::T_LIST, 5);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_I32, static_cast<uint32_t>(this->autoIncColumns.size()));
      std::vector<int32_t> ::const_iterator _iter226;
      for (_iter226 = this->autoIncColumns.begin(); _iter226 != this->autoIncColumns.end(); ++_iter226)
      {
        xfer += oprot->writeI32((*_iter226));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.autoIncColumnNames) {
    xfer += oprot->writeFieldBegin("autoIncColumnNames", ::apache::thrift::protocol::T_LIST, 6);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->autoIncColumnNames.size()));
      std::vector<std::string> ::const_iterator _iter227;
      for (_iter227 = this->autoIncColumnNames.begin(); _iter227 != this->autoIncColumnNames.end(); ++_iter227)
      {
        xfer += oprot->writeString((*_iter227));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.batchSize) {
    xfer += oprot->writeFieldBegin("batchSize", ::apache::thrift::protocol::T_I32, 7);
    xfer += oprot->writeI32(this->batchSize);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.fetchReverse) {
    xfer += oprot->writeFieldBegin("fetchReverse", ::apache::thrift::protocol::T_BOOL, 8);
    xfer += oprot->writeBool(this->fetchReverse);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.lobChunkSize) {
    xfer += oprot->writeFieldBegin("lobChunkSize", ::apache::thrift::protocol::T_I32, 9);
    xfer += oprot->writeI32(this->lobChunkSize);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.maxRows) {
    xfer += oprot->writeFieldBegin("maxRows", ::apache::thrift::protocol::T_I32, 10);
    xfer += oprot->writeI32(this->maxRows);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.maxFieldSize) {
    xfer += oprot->writeFieldBegin("maxFieldSize", ::apache::thrift::protocol::T_I32, 11);
    xfer += oprot->writeI32(this->maxFieldSize);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.timeout) {
    xfer += oprot->writeFieldBegin("timeout", ::apache::thrift::protocol::T_I32, 12);
    xfer += oprot->writeI32(this->timeout);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.cursorName) {
    xfer += oprot->writeFieldBegin("cursorName", ::apache::thrift::protocol::T_STRING, 13);
    xfer += oprot->writeString(this->cursorName);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.possibleDuplicate) {
    xfer += oprot->writeFieldBegin("possibleDuplicate", ::apache::thrift::protocol::T_BOOL, 14);
    xfer += oprot->writeBool(this->possibleDuplicate);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.poolable) {
    xfer += oprot->writeFieldBegin("poolable", ::apache::thrift::protocol::T_BOOL, 15);
    xfer += oprot->writeBool(this->poolable);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.doEscapeProcessing) {
    xfer += oprot->writeFieldBegin("doEscapeProcessing", ::apache::thrift::protocol::T_BOOL, 16);
    xfer += oprot->writeBool(this->doEscapeProcessing);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.pendingTransactionAttrs) {
    xfer += oprot->writeFieldBegin("pendingTransactionAttrs", ::apache::thrift::protocol::T_MAP, 17);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_I32, ::apache::thrift::protocol::T_BOOL, static_cast<uint32_t>(this->pendingTransactionAttrs.size()));
      std::map<TransactionAttribute::type, bool> ::const_iterator _iter228;
      for (_iter228 = this->pendingTransactionAttrs.begin(); _iter228 != this->pendingTransactionAttrs.end(); ++_iter228)
      {
        xfer += oprot->writeI32((int32_t)_iter228->first);
        xfer += oprot->writeBool(_iter228->second);
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(StatementAttrs &a, StatementAttrs &b) {
  using ::std::swap;
  swap(a.resultSetType, b.resultSetType);
  swap(a.updatable, b.updatable);
  swap(a.holdCursorsOverCommit, b.holdCursorsOverCommit);
  swap(a.requireAutoIncCols, b.requireAutoIncCols);
  swap(a.autoIncColumns, b.autoIncColumns);
  swap(a.autoIncColumnNames, b.autoIncColumnNames);
  swap(a.batchSize, b.batchSize);
  swap(a.fetchReverse, b.fetchReverse);
  swap(a.lobChunkSize, b.lobChunkSize);
  swap(a.maxRows, b.maxRows);
  swap(a.maxFieldSize, b.maxFieldSize);
  swap(a.timeout, b.timeout);
  swap(a.cursorName, b.cursorName);
  swap(a.possibleDuplicate, b.possibleDuplicate);
  swap(a.poolable, b.poolable);
  swap(a.doEscapeProcessing, b.doEscapeProcessing);
  swap(a.pendingTransactionAttrs, b.pendingTransactionAttrs);
  swap(a.__isset, b.__isset);
}

}}}} // namespace
