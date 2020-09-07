-- ==============================================================
--  View : VIEW1RENOMMEE                                    
-- ==============================================================
DROP VIEW DEMO.VIEW1;
CREATE OR REPLACE VIEW DEMO.VIEW1RENOMMEE AS select c, d from test;
COMMENT ON VIEW DEMO.VIEW1RENOMMEE IS 'comments on view1 updated';

-- ==============================================================
--  View : VIEW2                                    
-- ==============================================================
DROP VIEW DEMO.VIEW2;
CREATE OR REPLACE VIEW DEMO.VIEW2 AS select c, d, updated from test;
COMMENT ON VIEW DEMO.VIEW2 IS 'comments on view2 updated
';

