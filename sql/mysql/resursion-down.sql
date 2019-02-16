
CREATE FUNCTION queryChildrenAreaInfo(areaId INT)
RETURNS VARCHAR(4000)

BEGIN
	DECLARE sTemp VARCHAR(4000);
	DECLARE sTempChd VARCHAR(4000);

	SET sTemp='$';
	SET sTempChd = CAST(areaId AS CHAR);

	WHILE sTempChd IS NOT NULL DO
	SET sTemp= CONCAT(sTemp,',',sTempChd);
	SELECT 
    GROUP_CONCAT(id)
INTO sTempChd FROM
    t_areainfo
WHERE
    FIND_IN_SET(parentId, sTempChd) > 0;
	END WHILE;
	RETURN sTemp;
END;