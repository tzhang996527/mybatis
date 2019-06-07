package com.example.demomybatis.controller;

import com.example.demomybatis.dao.AssetTypeMapper;
import com.example.demomybatis.entity.AssetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class AssetController {

    private final AssetTypeMapper assetTypeMapper;

    @Autowired
    public AssetController(AssetTypeMapper assetTypeMapper) {
        this.assetTypeMapper = assetTypeMapper;
    }

    //get all asset type
    @GetMapping(path="assetType")
    public List<AssetType> getAllAssetType(){
        return this.assetTypeMapper.selectAll();
    }

    @GetMapping(path="assetType/{id}")
    public AssetType getAssetById(@PathVariable(name="id") String id){
        return this.assetTypeMapper.selectByPrimaryKey(id);
    }
    @PostMapping(path="assetType")
    public List<AssetType> createAssetType(@RequestBody AssetType assetType){
        this.assetTypeMapper.insert(assetType);
        return this.assetTypeMapper.selectAll();
//        return String.format("AssetType %s created.",assetType.getAssetType());
    }

    @DeleteMapping(path="assetType/{id}")
    public List<AssetType> deleteAssetType(@PathVariable(name="id") String id){
        this.assetTypeMapper.deleteByPrimaryKey(id);
        return this.assetTypeMapper.selectAll();
    }
}