-- ==============================================================
--  View : VIEW1RENOMMEE                                    
-- ==============================================================
DROP VIEW VIEW1;
CREATE OR REPLACE VIEW VIEW1RENOMMEE AS select c, d from test;
COMMENT ON VIEW VIEW1RENOMMEE IS 'comments on view1 updated';

-- ==============================================================
--  View : VIEW2                                    
-- ==============================================================
DROP VIEW VIEW2;
CREATE OR REPLACE VIEW VIEW2 AS select c, d, updated from test;
COMMENT ON VIEW VIEW2 IS 'comments on view2 updated
';

